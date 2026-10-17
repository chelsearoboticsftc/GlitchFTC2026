package org.firstinspires.ftc.teamcode.Subsystems;

public class blue_close {
    import static com.pedropathing.api.Paths.*;
import com.pedropathing.api.Paths;

import com.pedropathing.api.PoseFactory;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;

    public class Paths {

        private final PoseFactory poseFactory = PoseFactory.degrees();

        private final Pose goobermanD = poseFactory.of(81.9293, 9.1113, 90);
        private final Pose path = poseFactory.of(82.4463, 33.3298, -91.223);
        private final Pose yetanotherpath = poseFactory.of(135.7513, 32.1387, 149.5568);
        private final Pose yetanotherpathControl1 = poseFactory.of(107.7081, 48.7723, 0);

        public Path path() {
            return Paths.line(goobermanD, path).reverseTangent();
        }

        public Path yetanotherpath() {
            return Paths.curve(path, yetanotherpathControl1, yetanotherpath).reverseTangent();
        }
    }
}
