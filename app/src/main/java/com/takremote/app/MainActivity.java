package com.takremote.app;

import android.app.Activity;
import android.media.projection.MediaProjectionManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.graphics.Typeface;

public class MainActivity extends Activity {
    private static final int REQUEST_SCREEN_CAPTURE = 4101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout page = new LinearLayout(this);
        page.setOrientation(LinearLayout.VERTICAL);
        page.setPadding(36, 48, 36, 36);
        page.setGravity(Gravity.CENTER_HORIZONTAL);

        TextView title = new TextView(this);
        title.setText("TAK REMOTE");
        title.setTextSize(28);
        title.setTypeface(null, Typeface.BOLD);
        title.setGravity(Gravity.CENTER);
        page.addView(title, matchWrap());

        TextView note = new TextView(this);
        note.setText("\nपहला सुरक्षित प्रोटोटाइप\n\nदोनों फोन में यह ऐप इंस्टॉल होगा। Receiver फोन पर स्क्रीन शेयर करने से पहले Android की अनुमति जरूरी होगी।");
        note.setTextSize(16);
        note.setGravity(Gravity.CENTER);
        page.addView(note, matchWrap());

        Button controller = new Button(this);
        controller.setText("CONTROLLER MODE");
        page.addView(controller, matchWrap());
        controller.setOnClickListener(v -> showMessage("Controller mode चुना गया। इंटरनेट pairing और remote input अभी इस prototype में जोड़े नहीं गए हैं।"));

        Button receiver = new Button(this);
        receiver.setText("RECEIVER MODE");
        page.addView(receiver, matchWrap());
        receiver.setOnClickListener(v -> requestScreenShareConsent());

        TextView status = new TextView(this);
        status.setText("\nStatus: Not connected");
        status.setTextSize(14);
        status.setGravity(Gravity.CENTER);
        page.addView(status, matchWrap());

        setContentView(page);
    }

    private LinearLayout.LayoutParams matchWrap() {
        return new LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        );
    }

    private void requestScreenShareConsent() {
        MediaProjectionManager manager =
            (MediaProjectionManager) getSystemService(Context.MEDIA_PROJECTION_SERVICE);
        startActivityForResult(manager.createScreenCaptureIntent(), REQUEST_SCREEN_CAPTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_SCREEN_CAPTURE) {
            if (resultCode == RESULT_OK) {
                showMessage("स्क्रीन शेयरिंग की अनुमति मिली। यह prototype अभी स्क्रीन को इंटरनेट पर प्रसारित नहीं करता।");
            } else {
                showMessage("स्क्रीन शेयरिंग की अनुमति नहीं मिली। बिना अनुमति स्क्रीन साझा नहीं होगी।");
            }
        }
    }

    private void showMessage(String message) {
        new android.app.AlertDialog.Builder(this)
            .setTitle("Tak Remote")
            .setMessage(message)
            .setPositiveButton("ठीक है", null)
            .show();
    }
}
