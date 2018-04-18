package developersancho.loginmvvm;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import developersancho.loginmvvm.Interface.ILoginResultCallbacks;
import developersancho.loginmvvm.ViewModel.LoginViewModel;
import developersancho.loginmvvm.ViewModel.LoginViewModelFactory;
import developersancho.loginmvvm.databinding.ActivityMainBinding;
import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements ILoginResultCallbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(ViewModelProviders.of(this,
                new LoginViewModelFactory(this))
                .get(LoginViewModel.class));

    }

    @Override
    public void onSuccess(String message) {
        Toasty.success(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String message) {
        Toasty.error(this, message, Toast.LENGTH_SHORT).show();
    }
}
