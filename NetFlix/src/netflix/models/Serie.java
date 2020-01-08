package netflix.models;

import com.maurict.orm.Table;
import netflix.models.SeriesEpisode;

import java.util.ArrayList;

public class Serie extends Table {

    public int id;
    public String serieName;

    //It would be better if we store the id
    public String recommendedSerie;

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
            ArrayList<Object> pws = new SeriesEpisode().where("serieId",this.id).toList();
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
}
