package chapter.android.aweme.ss.com.chapter2.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

import chapter.android.aweme.ss.com.chapter2.R;

public class RelativeLayoutActivity extends AppCompatActivity {

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
        //System.out.println(VG.getChildCount());
        //txv.setText(Integer.toString(VG.getChildCount()));
        txv.setText(Integer.toString(count(VG)));

        //count(VG);
    }

    /**
     * 2020/3/24
     * 统计view的个数
     */

    /**
     * 非递归统计一个View的子View数(包含自身)
     *
     * @param root
     * @return
     */
    public int count(View root) {
        int viewCount = 0;

        if (null == root) {
            //return 0;
            System.out.println(viewCount);
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
        //System.out.println(viewCount);
    }



}
