/*
 *
 *  Copyright (C) 2011 DroniX Dev Team
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package org.dronix.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;

public class AirplanemodeToggleActivity extends Activity
{
    private static final long SCREEN_TIMEOUT = 2;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);

// read the airplane mode setting
        boolean isEnabled = Settings.System.getInt(
            getContentResolver(),
            Settings.System.AIRPLANE_MODE_ON, 0) == 1;

// toggle airplane mode
        Settings.System.putInt(
            getContentResolver(),
            Settings.System.AIRPLANE_MODE_ON, isEnabled ? 0 : 1);

// Post an intent to reload
        Intent intent = new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        intent.putExtra("state", !isEnabled);
        sendBroadcast(intent);
        finish();
    }
}
