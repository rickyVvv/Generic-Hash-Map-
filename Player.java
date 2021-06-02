public class Player {
    //declaring variables 
    private Player Next ;
    private String Name ;
    private int Hit;
    private int out ;
    private int strikeout;
    private int Walk ;
    private int HitbyPitch ;
    private int Sacrafice ;
    private int atbat;
    private int Errors;
    private float BattingAverage;
    private float OnBase;
    Player(){ //default constructor 
        Next = null;
        Name = "";
        Errors = 0;
        Hit = 0;
        out = 0;
        strikeout = 0;
        Walk =0;
        HitbyPitch = 0;
        Sacrafice = 0;
        atbat = Hit+out+strikeout+Errors;
        BattingAverage =0;
        OnBase = 0;
    }
    Player(Player temp) { // my overloaded Player constructor 
        this.Name = temp.Name;
        this.Hit = temp.Hit;
        this.out = temp.out;
        this.Errors = temp.Errors;
        this.strikeout = temp.strikeout;
        this.Walk = temp.Walk;
        this.HitbyPitch = temp.HitbyPitch;
        this.Sacrafice = temp.Sacrafice;
        this.atbat = temp.Hit+ temp.out + temp.strikeout + temp.Errors;
        this.BattingAverage = ((float)temp.Hit)/(temp.Hit+temp.out+temp.strikeout);
        this.OnBase = ((float)temp.Hit + temp.Walk + temp.HitbyPitch) / (temp.Hit + temp.out + temp.strikeout + temp.Walk + temp.HitbyPitch + temp.Sacrafice);
        if(temp != null){
            this.Next = new Player(temp.getNext());

        }
        else{
            Next = null;
        }
    }
    //all the Player functions i use! 
    public Player getNext() {return Next;}
    public String getName() {return Name;}
    public int getHit() {return Hit;}
    public int getErrors() {return Errors;}
    public int getout() {return out;}
    public int getstrikeout() {return strikeout;}
    public int getWalk() {return Walk;}
    public int getHitbyPitch() {return HitbyPitch;}
    public int getSacrafice() {return Sacrafice;}
    public void setErrors(int temp) {Errors = temp;}
    public void setName(String temp) {Name = temp;}
    public void setHit(int temp) {Hit = temp;}
    public void setout(int temp) {out = temp;}
    public void setstrikeout(int temp) {strikeout = temp;}
    public void setWalk(int temp) {Walk = temp;}
    public void setHitbyPitch(int temp) {HitbyPitch = temp;}
    public void setSacrafice(int temp) {Sacrafice = temp;}
    public int getAtbat() {return atbat;}
    public void setAtbat(int temp) { atbat = temp; }
    public float getBattingAverage(){return BattingAverage;}
    public void setBattingAverage(float temp){ BattingAverage = temp; }
    public float getOnBase(){return OnBase;}
    public void setOnBase(float temp){OnBase = temp;}
}
