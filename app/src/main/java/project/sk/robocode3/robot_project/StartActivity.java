package project.sk.robocode3.robot_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.roboid.android.RobotActivity;
import org.roboid.robot.Robot;

import java.util.Random;

public class StartActivity extends RobotActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

       }


    @Override
    public void onClick(View v) {
        Intent intent;
        Random r = new Random();
        switch (v.getId()){
            case R.id.button_choose_nation :
                int tempidx = r.nextInt(3);
                if(tempidx == 0)
                    intent = new Intent(getApplicationContext(), StackStartActivity1.class);
                else if(tempidx == 1)
                    intent = new Intent(getApplicationContext(), StackStartActivity2.class);
                else
                    intent = new Intent(getApplicationContext(), StackStartActivity3.class);

                startActivity(intent);
                break;
            case R.id.button_start_travel :
                intent = new Intent(getApplicationContext(), TravelStartActivity.class);
                int index = r.nextInt(CommonObject.nationCnt);
                intent.putExtra("index",index);
                startActivity(intent);
                break;
            case R.id.button_study :
                intent = new Intent(getApplicationContext(), StudyActivity.class);
                startActivity(intent);
                break;
        }
    }


    @Override
    public void onInitialized(Robot robot) {

    }
}
