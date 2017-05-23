package it.com.demo2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import rx.Observable;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by tony on 2017/5/22.
 */
public class UserPresenterTest {

    UserPresenter userPresenter;
    UserView userView;
    UserService userService;


    /**
     * 第一步：创建依赖的数据.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        RxUnitTestTools.openRxTools();
        // 生成mock对象
        userView = mock(UserView.class);
        userService = mock(UserService.class);
        userPresenter = new UserPresenterImpl(userService, userView);
    }

    @Test
    public void testLoadUser() throws Exception {
        User user = new User();
        user.uid = 1;
        user.name = "kkmike999";
        /**
         * 第二步：定义了模拟的调用方法.
         */
        //当调用userService.loadUser(...),参数为任意int,返回Observable.just(user)对象.
        //相当于与定义了UserService类测试用的时候使用的loadUser方法.
        when(userService.loadUser(anyInt())).thenReturn(Observable.just(user));

        /**
         * 第三步：执行一段逻辑
         */
        userPresenter.loadUser(1);

        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);


        /**
         * 第四步：验证行为或者数据.
         */
        //验证userService.loadUser(...)是否被调用,并校验传入参数uid==1.
        verify(userService).loadUser(1);

        //验证userView.onUserLoaded(...)是否被调用，并捕获传入的user参数
        verify(userView).onUserLoaded(captor.capture());

        User result = captor.getValue(); // 捕获的User

        Assert.assertEquals(result.uid, 1);
        Assert.assertEquals(result.name, "kkmike999");
    }
}


