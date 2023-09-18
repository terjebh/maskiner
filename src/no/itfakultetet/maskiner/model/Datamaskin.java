package no.itfakultetet.maskiner.model;

public class Datamaskin {

    private Integer årsmodell;
    private String merke;
    private String prosessor;
    private Integer pris;
    private Integer vekt;
    private Integer ram;

    public Datamaskin() {

    }

    public Integer getÅrsmodell() {
        return årsmodell;
    }

    public void setÅrsmodell(Integer årsmodell) {
        this.årsmodell = årsmodell;
    }

    public String getMerke() {
        return merke;
    }

    public void setMerke(String merke) {
        this.merke = merke;
    }

    public String getProsessor() {
        return prosessor;
    }

    public void setProsessor(String prosessor) {
        this.prosessor = prosessor;
    }

    public Integer getPris() {
        return pris;
    }

    public void setPris(Integer pris) {
        this.pris = pris;
    }

    public Integer getVekt() {
        return vekt;
    }

    public void setVekt(Integer vekt) {
        this.vekt = vekt;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    @Override
    public String toString() {
        return "Datamaskin{" +
                "årsmodell='" + årsmodell + '\'' +
                ", merke='" + merke + '\'' +
                ", prosessor='" + prosessor + '\'' +
                ", pris=" + pris +
                ", vekt=" + vekt +
                ", ram=" + ram +
                '}';
    }
}
