package chapter.android.aweme.ss.com.homework;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.widget.CircleImageView;

public class dy_adapter extends RecyclerView.Adapter<dy_adapter.NumberViewHolder> {
    private static final String TAG = "GreenAdapter";
    public List<mes> MesList;
    private int mNumberItems;
    private final ListItemClickListener mOnClickListener;
    private static int viewHolderCount;
    public dy_adapter(int numListItems, ListItemClickListener listener,List<mes> MesList) {
        mNumberItems = numListItems;
        mOnClickListener = listener;
        viewHolderCount = 0;
        this.MesList=MesList;
    }


    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.im_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        NumberViewHolder viewHolder = new NumberViewHolder(view);
        viewHolder.itemView.setBackgroundColor(Color.rgb(0, 0, 0));

        Log.d(TAG, "onCreateViewHolder: number of ViewHolders created: " + viewHolderCount);
        viewHolderCount++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder numberViewHolder, int position) {
        Log.d(TAG, "onBindViewHolder: #" + position);
        numberViewHolder.bind(position);

        /****
         * 2020/3/28 UI显示解析出来的内容
         * name  message  time
         */
        String name;
        name=MesList.get(position).getName();
        numberViewHolder.TimeView.setText(MesList.get(position).getTime());
        numberViewHolder.NameView.setText(MesList.get(position).getMessage());
        numberViewHolder.MessageView.setText(MesList.get(position).getName());
        Log.d(TAG, "ITEM" + position);

        /**
         * 2020/3/29
         * 圆形头像
         */
//        numberViewHolder.CV.setImageDrawable(getResources().getDrawable(R.drawable.session_robot));
        //numberViewHolder.CV.setImageResource(R.drawable.icon_blacksend_touch);
        switch (name){
            case"游戏小助手":
                numberViewHolder.CV.setImageResource(R.drawable.icon_micro_game_comment);
                numberViewHolder.IV.setImageResource(R.drawable.im_icon_notice_official);
                break;
            case"抖音小助手":
                numberViewHolder.CV.setImageResource(R.drawable.session_robot);
                numberViewHolder.IV.setImageResource(R.drawable.im_icon_notice_official);
                break;
            case"陌生人消息":
                numberViewHolder.CV.setImageResource(R.drawable.session_stranger);
                break;
            case "系统消息":
                numberViewHolder.CV.setImageResource(R.drawable.session_system_notice);
                numberViewHolder.IV.setImageResource(R.drawable.im_icon_notice_official);
                break;
            default:
                numberViewHolder.CV.setImageResource(R.drawable.icon_girl);
                break;

        }

    }


    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    public class NumberViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView NameView;
        private final TextView MessageView;
        private final TextView TimeView;
        private final CircleImageView CV;
        private final ImageView IV;

        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);
            MessageView = (TextView) itemView.findViewById(R.id.tv_title);
            NameView = (TextView) itemView.findViewById(R.id.tv_description);
            TimeView=(TextView)itemView.findViewById(R.id.tv_time);
            CV=(CircleImageView)itemView.findViewById(R.id.iv_avatar);
            IV=(ImageView)itemView.findViewById(R.id.robot_notice);
            itemView.setOnClickListener(this);
        }

        public void bind(int position) {
            MessageView.setText(String.valueOf(position));

        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            if (mOnClickListener != null) {
                mOnClickListener.onListItemClick(clickedPosition);
            }
        }
    }

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }
}
