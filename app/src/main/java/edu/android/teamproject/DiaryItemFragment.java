package edu.android.teamproject;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DiaryItemFragment extends Fragment {


    public DiaryItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_diary_item, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        View view = getView();

        RecyclerView recyclerView = view.findViewById(R.id.diaryRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        DiaryItemAdapter adapter = new DiaryItemAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }

    class DiaryItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        class DiaryItemViewHolder extends RecyclerView.ViewHolder {

            private ImageView imageView;
            private EditText diaryText;
            private TextView textDate, textTag;
            private Button btnFavorites, btnShare, btnUpdate, btnDelete;

            public DiaryItemViewHolder(@NonNull View itemview) {
                super(itemview);

                imageView = itemview.findViewById(R.id.imageView);
                diaryText = itemview.findViewById(R.id.diaryText);
                textDate = itemview.findViewById(R.id.textDate);
                textTag = itemview.findViewById(R.id.textTag);
                btnFavorites = itemview.findViewById(R.id.btnFavorites);
                btnShare = itemview.findViewById(R.id.btnShare);
                btnUpdate = itemview.findViewById(R.id.btnUpdate);
                btnDelete = itemview.findViewById(R.id.btnDelete);
            }
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View diaryView = inflater.inflate(R.layout.diary_item,viewGroup, false);
            DiaryItemViewHolder holder = new DiaryItemViewHolder(diaryView);

            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            DiaryItemViewHolder holder = (DiaryItemViewHolder) viewHolder;
        }

        @Override
        public int getItemCount() {
            return 1;
        }

    }
}
