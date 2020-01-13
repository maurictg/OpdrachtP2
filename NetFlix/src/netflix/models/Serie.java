package netflix.models;

import com.maurict.orm.Database;
import com.maurict.orm.Table;

import java.util.ArrayList;
import java.util.HashMap;

public class Serie extends Table {

    public int serieId;
    public String serieName;
    public int recommendedSerie; //accountId

    private ArrayList<Program> episodeList;
    private boolean includesEpisodeList;

    public Serie() {
        super("Series", "serieId");
        this.episodeList = new ArrayList<>();
        this.includesEpisodeList = false;
    }

    public ArrayList<Program> getEpisodeList() {
        if (!includesEpisodeList) {
            this.includeEpisodeList();
        }

        return episodeList;
    }

    public void includeEpisodeList() {
        try {
            ArrayList<Object> pws = new SeriesEpisode().select().where("serieId", this.serieId).toList();
            for (Object p : pws) {
                episodeList.add(((SeriesEpisode)p).getProgram());
            }

            /* //This must be better because this takes 1 query with innerJoin instead of 2, but we should have to test this
            ArrayList<Object> programs =
                    new Program().select()
                            .innerJoin("ProgramSeries","programId")
                            .raw(" INNER JOIN Series ON Series.accountId = ProgramSeries.accountId")
                            .where("accountId",this.accountId)
                            .toList();*/

            this.includesEpisodeList = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean addEpisode(Program p) {
        //If accountId = 0, the program is not filled so must be created
        try {
            int id = p.programId;
            if (id == 0) {
                Database.global.add(p);
                id = new Program().select().where("title", p.title).and("time", p.time).firstInt();
            }

            p.programId = id;
            SeriesEpisode wp = new SeriesEpisode();
            wp.programId = id;
            wp.serieId = this.serieId;
            Database.global.add(wp);
            episodeList.add(p);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

