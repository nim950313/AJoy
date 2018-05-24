package project.sk.robocode3.robot_project;

public class NationObject {

    //현재 초록깃발-51814(한국) 파랑-51815(미국) 빨강-51811(중국) 노랑-51813(일본)

    //기본정보(모든 나라마다 다른 정보)
    public int index;       //나라인덱스
    public int oid;         //오아이디

    public String name;     //나라이름

    public String cho;      //초성
    public String dae; // 대륙명
    public String capital; //수도명
    public String landmark; //유적지명
    public int people; //인구수(1000단위)
    public int size; //면적크기(km제곱)

    public int landmarkImage; //유적지 Drawable
    public int capitalImage; //수도 Drawable
    public int flagImage;   //국기 Drawble

    //방문횟수
    public int visitNum;

}
