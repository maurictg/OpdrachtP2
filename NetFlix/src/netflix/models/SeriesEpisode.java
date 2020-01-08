package netflix.models;

import com.maurict.orm.Table;

public class SeriesEpisode extends Table {

    public int id;
    public int programId;
    public int serieId;

    private Serie serie;
    private Program program;

    private boolean includesSerie;
    private boolean includesProgram;

    public SeriesEpisode(){
        super("ProgramSeries");
        this.includesSerie = false;
        this.includesProgram = false;
    }

    public Serie getSerie() {
        if(!includesSerie){
            this.includeSerie();
        }

        return serie;
    }

    public Program getProgram() {
        if(!includesProgram){
            this.includeProgram();
        }

        return program;
    }

    public void includeSerie(){
        try {
            //Get serie from database
            this.serie = (Serie)new Serie().find(serieId);
            this.includesSerie = true;
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void includeProgram(){
        try {
            //Get program from database
            this.program = (Program)new Program().find(programId);
            this.includesProgram = true;
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
