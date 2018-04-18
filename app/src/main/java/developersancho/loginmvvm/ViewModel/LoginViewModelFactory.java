package developersancho.loginmvvm.ViewModel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import developersancho.loginmvvm.Interface.ILoginResultCallbacks;

public class LoginViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private ILoginResultCallbacks loginResultCallbacks;

    public LoginViewModelFactory(ILoginResultCallbacks loginResultCallbacks) {
        this.loginResultCallbacks = loginResultCallbacks;
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new LoginViewModel(loginResultCallbacks);
    }
}
