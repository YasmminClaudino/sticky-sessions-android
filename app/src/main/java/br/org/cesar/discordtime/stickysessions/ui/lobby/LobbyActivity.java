package br.org.cesar.discordtime.stickysessions.ui.lobby;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import br.org.cesar.discordtime.stickysessions.R;
import br.org.cesar.discordtime.stickysessions.presentation.lobby.LobbyContract;
import br.org.cesar.discordtime.stickysessions.presentation.lobby.LobbyPresenter;

public class LobbyActivity extends AppCompatActivity implements LobbyContract.View,
        android.view.View.OnClickListener {

    private Context mContext;
    private ViewGroup parent;
    private LobbyContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        parent = findViewById(R.id.container);
        mPresenter = new LobbyPresenter();
        mPresenter.attachView(this);

        Button createStarfish = findViewById(R.id.create_starfish);
        Button createGainPleasure = findViewById(R.id.create_gain_pleasure);
        Button enterSession = findViewById(R.id.enter_session);

        createStarfish.setOnClickListener(this);
        createGainPleasure.setOnClickListener(this);
        enterSession.setOnClickListener(this);
    }

    @Override
    public void onClick(android.view.View view) {
        switch (view.getId()){
            case R.id.create_starfish:
                mPresenter.onCreateStarfish();
                break;
            case R.id.create_gain_pleasure:
                mPresenter.onCreateGainPleasure();
                break;
            case R.id.enter_session:
                mPresenter.onAskSessionId();
                break;
            default:
                break;
        }
    }

    @Override
    public void displaySessionForm() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        final android.view.View view =
                inflater.inflate(R.layout.dialog_session_form, parent, false);
        builder.setView(view);
        builder.setMessage(getString(R.string.enter_session_id));
        builder.setPositiveButton(getString(R.string.confirm), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                EditText editText = view.findViewById(R.id.editText);
                String sessionIdString = editText.getText().toString();
                mPresenter.onEnterSession(sessionIdString);
            }
        });
    }

    @Override
    public void displayError(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
