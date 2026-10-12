package org.firstinspires.ftc.teamcode.Subsystems;

public class autonomous {

    import static com.pedropathing.api.Paths.*;
import com.pedropathing.api.Paths;

import com.pedropathing.api.PoseFactory;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;

    public class Paths {

        private final PoseFactory poseFactory = PoseFactory.degrees();

        private final Pose goobermanD = poseFactory.of(70.8168, 25.7801, 90);
        private final Pose goobermanD_2 = poseFactory.of(70.5648, 121.752, -10.0038);
        private final Pose goobermanD_2Control1 = poseFactory.of(138.1571, 29.2565, 0);
        private final Pose goobermanD_2Control2 = poseFactory.of(123.3364, 113.2605, 0);
        private final Pose gobertiler12 = poseFactory.of(70.7003, 26.2173, 90.0812);

        public Path goobermanD() {
            return Paths.curve(goobermanD, goobermanD_2Control1, goobermanD_2Control2, goobermanD_2).reverseTangent();
        }

        public Path gobertiler12() {
            return Paths.line(goobermanD_2, gobertiler12).reverseTangent();
        }
    }



}
