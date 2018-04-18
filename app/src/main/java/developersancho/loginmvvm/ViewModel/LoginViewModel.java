package developersancho.loginmvvm.ViewModel;

import android.arch.lifecycle.ViewModel;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import developersancho.loginmvvm.Interface.ILoginResultCallbacks;
import developersancho.loginmvvm.Model.User;

public class LoginViewModel extends ViewModel {
    private User user;
    private ILoginResultCallbacks loginResultCallbacks;

    public LoginViewModel(ILoginResultCallbacks loginResultCallbacks) {
        this.user = new User();
        this.loginResultCallbacks = loginResultCallbacks;
    }

    public TextWatcher getEmailTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                user.setEmail(s.toString());
            }
        };
    }

    public TextWatcher getPasswordTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                user.setPassword(s.toString());
            }
        };
    }

    public void onLoginClicked(View view) {
        int errorCode = user.isValidData();
        if (errorCode == 0) {
            loginResultCallbacks.onError("You must enter email address");
        } else if (errorCode == 1) {
            loginResultCallbacks.onError("Your email is invalid");
        } else if (errorCode == 2) {
            loginResultCallbacks.onError("Password length must greater than 6 characters");
        } else {
            loginResultCallbacks.onSuccess("Login Success");
        }
    }

}
