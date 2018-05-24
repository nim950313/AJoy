package project.sk.robocode3.robot_project;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import org.roboid.android.Connector;
import org.roboid.android.HardwareWorld;
import org.roboid.android.RobotActivity;
import org.roboid.robot.Robot;

import kr.robomation.physical.UoAlbert;

import static project.sk.robocode3.robot_project.CommonObject.robot;


public class MainActivity extends RobotActivity implements View.OnClickListener {

    public PopupWindow popupWindow_ready;
    public View popupView_ready;
    public Thread th;
    public int frontOID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HardwareWorld hardwareWorld = Connector.mWorld;
        robot = hardwareWorld.findRobotById(UoAlbert.ID, 0);

        CommonObject.mOidDevice =  robot.findDeviceById(UoAlbert.OID);


        popupView_ready = getLayoutInflater().inflate(R.layout.popup_ready, null);
        popupWindow_ready = new PopupWindow(popupView_ready, RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT,true);

        th = new Thread(new Runnable() {
            @Override
            public void run() {

                frontOID = -1;
                while(true){
                    if( CommonObject.mOidDevice.e()) // 이벤트가 발생하였다.
                    {
                        frontOID =  CommonObject.mOidDevice.read();
                        Log.e("frontOID",""+frontOID);
                        if(popupWindow_ready.isShowing()){
                            if(frontOID == CommonObject.name_oid) {
                                CommonObject.mode = 0;
                                Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                                startActivity(intent);
                            }else if(frontOID == CommonObject.flag_oid){
                                CommonObject.mode = 1;
                                Intent intent = new Intent(getApplicationContext(), StartActivity.class);
                                startActivity(intent);
                            }else{

                            }
                        }
                    }
                }
            }
        });
        th.start();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_start_game :
                popupWindow_ready.showAtLocation(popupView_ready, Gravity.CENTER,0,0);
                break;
            case R.id.button_exit_app :
                finish();
                break;
        }
    }

    @Override
    public void onInitialized(Robot robot) {


    }
}
