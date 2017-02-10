/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Piasy
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.piasy.octostars.di;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import com.f2prateek.rx.preferences2.RxSharedPreferences;
import com.github.piasy.bootstrap.base.model.jsr310.JSR310Module;
import com.github.piasy.bootstrap.base.model.jsr310.ThreeTenABPDelegate;
import com.github.piasy.bootstrap.base.model.provider.ProviderModule;
import com.github.piasy.bootstrap.base.utils.ScreenUtil;
import com.github.piasy.bootstrap.base.utils.ToastUtil;
import com.github.piasy.bootstrap.base.utils.UtilsModule;
import com.github.piasy.octostars.bridge.MiscModule;
import com.github.piasy.octostars.bridge.RxNetErrorProcessor;
import com.google.gson.Gson;
import com.squareup.sqlbrite.BriteDatabase;
import dagger.Component;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import org.greenrobot.eventbus.EventBus;
import org.threeten.bp.format.DateTimeFormatter;
import retrofit2.Retrofit;

/**
 * Created by Piasy{github.com/Piasy} on 15/7/23.
 *
 * DI appComponent abstraction for Application scope.
 * Application scope is {@link Singleton} scope, sub appComponent like {@link
 * com.github.piasy.yamvp.dagger2.ActivityScope} could have wilder scope.
 *
 * We put it inside app module, because {@link ProviderConfigModule} must locate in app module,
 * and there is no other side effect with this manner, besides, we can use
 * {@link dagger.Subcomponent} to define sub component, which need less code.
 */
@Singleton
@Component(
        modules = {
                AppModule.class,

                ProviderModule.class, ProviderConfigModule.class,

                JSR310Module.class, UtilsModule.class,

                MiscModule.class,
        })
public interface AppComponent {
    Application application();

    Context context();

    Resources resources();

    DateTimeFormatter dateTimeFormatter();

    EventBus eventBus();

    OkHttpClient okHttpClient();

    Retrofit retrofit();

    Gson gson();

    BriteDatabase briteDatabase();

    RxSharedPreferences rxSharedPreferences();

    ThreeTenABPDelegate threeTenABPDelegate();

    ToastUtil toastUtil();

    RxNetErrorProcessor rxNetErrorProcessor();

    ScreenUtil screenUtil();
}
