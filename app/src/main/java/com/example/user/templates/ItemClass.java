package com.example.user.templates;

public class ItemClass { // 사용자들의 정보를 담는 클래스. 이름, 과, 분반 등의 개인 정보를 담고 있다.
    private String Name;
    private String Department;
    private String Boonban;
    private String Club;
    private String Year;

    private String dw; // department weight
    private String cw; // club weight
    private String bw; // boonban weight
    private double score = 0; // user와 친한 정도를 계산하여 저장하는 변수

    public ItemClass() { // default 생성자
    }

    public ItemClass(String a, String b, String c, String d, String e, String f, String g, String h, double i) {
        this.Name = a;
        this.Department = b;
        this.Boonban = c;
        this.Club = d;
        this.Year = e;
        this.dw = f;
        this.cw = g;
        this.bw = h;
        this.score = i;
    }
        // 개인 정보를 set하는 code
    public void setName(String title) {
        this.Name = title ;
    }
    public void setDepartment(String desc) {
        this.Department = desc ;
    }
    public void setBoonban(String title) {
        this.Boonban = title ;
    }
    public void setClub(String desc) {
        this.Club = desc ;
    }
    public void setYear(String year){this.Year=year;}
    public void setdw(String _dw) {this.dw = _dw;}
    public void setcw(String _cw) {this.cw = _cw;}
    public void setbw(String _bw) {this.bw = _bw;}
    public void setScore(double sco) {this.score = sco;}

        // 개인 정보를 get하는 code
    public String getName() {
        return Name ;
    }
    public String getDepartment() {
        return Department ;
    }
    public String getBoonban() {
        return Boonban ;
    }
    public String getClub() {
        return Club ;
    }
    public String getYear(){return Year;}
    public String getdw() {return dw;}
    public String getcw() {return cw;}
    public String getbw() {return bw;}
    public double getScore() {return score;}


        // 점수를 계산하는 과정
    public void calScore(ItemClass item)
    {
        this.score = 40; // 일단 기본 값으로 40을 주고

        if((this.Department).equals(item.getDepartment())) // 과가 같으면 점수를 더해주고
        {
            score+=(Double.parseDouble(this.dw)+Double.parseDouble(item.getdw()))*(5.0);
        }
        if((this.Boonban).equals(item.getBoonban())) // 분반이 같으면 점수를 추가해주고
        {
            score+=(Double.parseDouble(this.bw)+Double.parseDouble(item.getbw()))*(5.0);
        }
        if((this.Club).equals((item.getClub()))) // 동아리가 같으면 점수를 또 추가해준다.
        {
            score+=(Double.parseDouble(this.cw)+Double.parseDouble(item.getcw()))*(5.0);
        }

            // 가까운 학번일수록 친할 가능성이 높다는 점을 염두에 두고 학번 차이가 많이 나는만큼 socre를 줄였다.
       if(Double.parseDouble(this.Year)-Double.parseDouble(item.getYear()) == 0.0)
    {
        score = score;
    }
    else if(Double.parseDouble(this.Year)-Double.parseDouble(item.getYear()) == 1.0 || Double.parseDouble(this.Year)-Double.parseDouble(item.getYear())==-1.0)
    {
        score = score*0.9;
    }
    else if(Double.parseDouble(this.Year)-Double.parseDouble(item.getYear()) == 2.0 || Double.parseDouble(this.Year)-Double.parseDouble(item.getYear())==-2.0)
    {
        score = score*0.8;
    }
    else if(Double.parseDouble(this.Year)-Double.parseDouble(item.getYear()) == 3.0 || Double.parseDouble(this.Year)-Double.parseDouble(item.getYear())==-3.0)
    {
        score = score*0.7;
    }
    else
    {
        score = score*0.6;
    }
    }
}


