package com.zyk.experiment1;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.zyk.experiment1.dao.FruitDao;

import com.zyk.experiment1.domain.Fruit;

import java.util.ArrayList;
import java.util.List;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.zyk.experiment1", appContext.getPackageName());
        //FruitDao fruitDao = new FruitDaoImpl(appContext);
        List<Fruit> list = new ArrayList<>();
        String[] fruitList = {"苹果", "梨子", "葡萄", "橘子", "芒果", "荔枝", "龙眼", "西瓜", "柿子", "火龙果", "猕猴桃"};
        String[] infoList = {"产地：中国 价格：2/斤 营养特点：猜猜", "产地：中国 价格：2/斤 营养特点：猜猜",
                "产地：中国 价格：2/斤 营养特点：猜猜", "产地：中国 价格：2/斤 营养特点：猜猜",
                "产地：中国 价格：2/斤 营养特点：猜猜", "产地：中国 价格：2/斤 营养特点：猜猜",
                "产地：中国 价格：2/斤 营养特点：猜猜", "产地：中国 价格：2/斤 营养特点：猜猜",
                "产地：中国 价格：2/斤 营养特点：猜猜", "产地：中国 价格：2/斤 营养特点：猜猜",
                "产地：中国 价格：2/斤 营养特点：猜猜",};

        /*for (int i = 0; i < fruitList.length; i++) {
            Fruit fruit = new Fruit();
            fruit.setName(fruitList[i]);
            fruit.setInfo(infoList[i]);
            if (i % 5 == 0) {
                fruit.setImageId(R.drawable.pingguo);
            } else if (i % 5 == 1) {
                fruit.setImageId(R.drawable.lizi);
            } else if (i % 5 == 2) {
                fruit.setImageId(R.drawable.putao);
            } else if (i % 5 == 3) {
                fruit.setImageId(R.drawable.chengzi);
            }else {
                fruit.setImageId(R.drawable.mangguo);
            }

            list.add(fruit);
        }
        for (Fruit fruit : list) {
            fruitDao.insert(fruit);
        }*/

    }
}