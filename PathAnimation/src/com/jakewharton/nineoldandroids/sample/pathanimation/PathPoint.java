/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * A class that holds information about a location and how the path should get to that
 * location from the previous path location (if any). Any PathPoint holds the information for
 * its location as well as the instructions on how to traverse the preceding interval from the
 * previous location.
 */
public class PathPoint {

    /**
     * The possible path operations that describe how to move from a preceding PathPoint to the
     * location described by this PathPoint.
     */
    public static final int MOVE = 0;
    public static final int LINE = 1;
    public static final int CURVE = 2;

    /**
     * The location of this PathPoint
     */
    float mX, mY;

    /**
     * The first control point, if any, for a PathPoint of type CURVE
     */
    float mControl0X, mControl0Y;

    /**
     * The second control point, if any, for a PathPoint of type CURVE
     */
    float mControl1X, mControl1Y;

    /**
     * The motion described by the path to get from the previous PathPoint in an AnimatorPath
     * to the location of this PathPoint. This can be one of MOVE, LINE, or CURVE.
     */
    int mOperation;



    /**
     * Line/Move constructor
     */
    private PathPoint(int operation, float x, float y) {
        mOperation = operation;
        mX = x;
        mY = y;
    }

    /**
     * Curve constructor
     */
    private PathPoint(float c0X, float c0Y, float c1X, float c1Y, float x, float y) {
        mControl0X = c0X;
        mControl0Y = c0Y;
        mControl1X = c1X;
        mControl1Y = c1Y;
        mX = x;
        mY = y;
        mOperation = CURVE;
    }

    /**
     * Constructs and returns a PathPoint object that describes a line to the given xy location.
     */
    public static PathPoint lineTo(float x, float y) {
        return new PathPoint(LINE, x, y);
    }

    /**
     * Constructs and returns a PathPoint object that describes a cubic B�zier curve to the
     * given xy location with the control points at c0 and c1.
     */
    public static PathPoint curveTo(float c0X, float c0Y, float c1X, float c1Y, float x, float y) {
        return new PathPoint(c0X,  c0Y, c1X, c1Y, x, y);
    }

    /**
     * Constructs and returns a PathPoint object that describes a discontinuous move to the given
     * xy location.
     */
    public static PathPoint moveTo(float x, float y) {
        return new PathPoint(MOVE, x, y);
    }
}


Nine Old Androids
=================

Android library for using the [Honeycomb (Android 3.0) animation API][1] on all
versions of the platform back to 1.0!

Note: `LayoutTransition` is present and it is not be possible to implement prior
to Android 3.0.



Usage
=====

The API is exactly the same as the [Honeycomb API][2], just change your imports
to use `com.nineoldandroids.XXX`.

Take a look at a few demos taken from the [platform ApiDemos][3] in the
`sample/` folder. You can also try it out on the [Play Store][4].

More information is available on [nineoldandroids.com][6].


Including In Your Project
-------------------------

This library is presented as a `.jar` file which you can include in the `libs/`
folder of your application. You can download the latest version from the
[GitHub downloads page][5].

If you are a Maven user you can easily include the library by specifying it as
a dependency:

    <dependency>
      <groupId>com.nineoldandroids</groupId>
      <artifactId>library</artifactId>
      <version>2.4.0</version>
    </dependency>



Developed By
============

* Jake Wharton - <jakewharton@gmail.com>



License
=======

    Copyright 2012 Jake Wharton

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.



 [1]: http://android-developers.blogspot.com/2011/02/animation-in-honeycomb.html
 [2]: http://developer.android.com/reference/android/view/animation/package-summary.html
 [3]: http://developer.android.com/resources/samples/ApiDemos/src/com/example/android/apis/animation/index.html
 [4]: https://play.google.com/store/apps/details?id=com.jakewharton.nineoldandroids.sample
 [5]: https://github.com/JakeWharton/NineOldAndroids/downloads
 [6]: http://nineoldandroids.com
