package org.firstinspires.ftc.teamcode.Autos;

import android.graphics.Path;

import com.pedropathing.api.PoseFactory;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.curves.Line;
import static com.pedropathing.api.Paths.;
import com.pedropathing.api.Paths;

import com.pedropathing.api.PoseFactory;
import com.pedropathing.math.Pose;

public class redAutoShootParkFar

public class Paths {

    private final PoseFactory poseFactory = PoseFactory.degrees();

    private final Pose start = poseFactory.of(60.0668, 133.0149, 90);
    private final Pose path1 = poseFactory.of(59.0615, 111.2825, -92.6485);
    private final Pose point2 = poseFactory.of(17.106, 121.1152, 166.8103);

    public Path path1() {
        return Paths.Line(start, path1).tangent();
    }

    public Path path2() {
        return Paths.Line(path1, point2).tangent();
    }
  }
}
