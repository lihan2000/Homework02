package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {


    private ViewGroup VG;
    private TextView txv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relativelayout);


        /**
         * 2020/3/25
         *
         */
        VG=findViewById(R.id.relative_layout);
        txv=findViewById(R.id.tv_center);
        //txv.setText(Integer.toString(VG.getChildCount()));
        txv.setText(Integer.toString(getAllChildViewCount(VG)));

        //count(VG);
    }

    /**
     * 2020/3/24
     * 统计view的个数
     */

    public int getAllChildViewCount(View root) {
        int viewCount = 0;

        if (null == root) {
            return 0;

        }

        if (root instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) root;
            LinkedList<ViewGroup> queue = new LinkedList<ViewGroup>();
            queue.add(viewGroup);
            while (!queue.isEmpty()) {
                ViewGroup current = queue.removeFirst();
                viewCount++;
                for (int i = 0; i < current.getChildCount(); i++) {
                    if (current.getChildAt(i) instanceof ViewGroup) {
                        queue.addLast((ViewGroup) current.getChildAt(i));
                    } else {
                        viewCount++;
                    }
                }
            }
        } else {
            viewCount++;
        }

        return viewCount-1;

    }
}
