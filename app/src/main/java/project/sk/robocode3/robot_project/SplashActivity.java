package project.sk.robocode3.robot_project;

import android.content.Intent;
import android.os.Bundle;

import org.roboid.android.RobotActivity;
import org.roboid.robot.Robot;

public class SplashActivity extends RobotActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        InitNation();

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);


    }

    @Override
    public void onInitialized(Robot robot) {

    }

    public void InitNation(){

        CommonObject.nation = new NationObject[CommonObject.nationCnt];

        String[] name = new String[]{"한국","일본","중국","미국"};
        String[] cho = new String[]{"ㅎㄱ","ㅇㅂ","ㅈㄱ","ㅁㄱ"};
        String[] dae = new String[]{"아시아","아시아","아시아","북아메리카"};
        String[] captial = new String[]{"서울","도쿄","베이징","워싱턴"};
        String[] landmark = new String[]{"광화문","도쿄타워","만리장성","자유의 여신상"};
        int[] people = new int[]{5000,2000,6000,7000};
        int[] oid = new int[]{51814,51813,51811,51815};
        int[] size = new int[]{400,200,1000,900};
        int[] flagImage = new int[]{R.drawable.korea,R.drawable.japan,R.drawable.china,R.drawable.america};
        int[] landmarkImage = new int[]{R.drawable.korea,R.drawable.japan,R.drawable.china,R.drawable.america};
        int[] capitalImage =   new int[]{R.drawable.seoul,R.drawable.tokyo,R.drawable.beijing,R.drawable.washington};
        for(int i=0; i<CommonObject.nationCnt;i++){
            NationObject nation = new NationObject();
            nation.index = i;
            nation.oid = oid[i];
            nation.name = name[i];
            nation.cho = cho[i];
            nation.dae = dae[i];
            nation.capital = captial[i];
            nation.landmark = landmark[i];
            nation.people = people[i];
            nation.size = size[i];

            nation.flagImage = flagImage[i];
            nation.landmarkImage = landmarkImage[i];
            nation.capitalImage = capitalImage[i];

            nation.visitNum = 0;

            CommonObject.nation[i] = nation;
        }

    }
}
