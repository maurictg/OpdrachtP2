package netflix.models;

import com.maurict.orm.Database;
import com.maurict.orm.Table;
import netflix.models.SeriesEpisode;

import java.util.ArrayList;

public class Serie extends Table {

    public int id;
    public String serieName;
    public int recommendedSerie; //id

    private ArrayList<Program> episodeList;
    private boolean includesEpisodeList;

    public Serie(){
        super("Series");
        this.episodeList = new ArrayList<>();
        this.includesEpisodeList = false;
    }

    public ArrayList<Program> getEpisodeList() {
        if(!includesEpisodeList){
            this.includeEpisodeList();
        }

        return episodeList;
    }

    public void includeEpisodeList(){
        try {
            ArrayList<Object> pws = new SeriesEpisode().select().where("serieId",this.id).toList();
            for (Object p: pws) {
                episodeList.add(((SeriesEpisode)p).getProgram());
            }

            /* //This must be better because this takes 1 query with innerJoin instead of 2, but we should have to test this
            ArrayList<Object> programs =
                    new Program().select()
                            .innerJoin("ProgramSeries","programId")
                            .raw(" INNER JOIN Series ON Series.id = ProgramSeries.id")
                            .where("id",this.id)
                            .toList();*/

            this.includesEpisodeList = true;
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean addEpisode(Program p) {
        //If id = 0, the program is not filled so must be created
        try{
            int id = p.id;
            if(id == 0) {
                Database.global.add(p);
                id = new Program().select().where("title",p.title).and("time",p.time).firstInt();
            }

            p.id = id;
            SeriesEpisode wp = new SeriesEpisode();
            wp.programId = id;
            wp.serieId = this.id;
            Database.global.add(wp);
            episodeList.add(p);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
