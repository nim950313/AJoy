package project.sk.robocode3.robot_project;

import org.roboid.robot.Device;
import org.roboid.robot.Robot;

/**
 * Created by minjeong on 2018-05-09.
 */

public class CommonObject {
    //연결된 하드웨어 장치. main에서 셋팅함.

    static int nationCnt = 4;
    static NationObject[] nation ;
    static int name_oid = 51816;
    //남색깃발 - 51816,
    static int flag_oid = 51817;
    //보라깃발 - 51817
    static int mode;
    //0이면 나라이름보드, 1이면 국기보드

    static Robot robot;
    static Device mLeftWheelDevice;
    static Device mRightWheelDevice;
    static Device mOidDevice;
    static Device mLeftEyeDevice;
    static Device mRightEyeDevice;
    static Device mBuzzerDevice;
    static int right_wheel_speed = 0;
    static int left_wheel_speed = 0;
}
