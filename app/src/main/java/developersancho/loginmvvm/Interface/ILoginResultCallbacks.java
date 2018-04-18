package developersancho.loginmvvm.Interface;

public interface ILoginResultCallbacks {
    void onSuccess(String message);

    void onError(String message);
}
