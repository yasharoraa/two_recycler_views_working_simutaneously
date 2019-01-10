package com.kkekk.pshare.Fragments;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.kkekk.pshare.Models.Album;
import com.kkekk.pshare.R;
import com.kkekk.pshare.Utils.SquareImage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import butterknife.Unbinder;

public class HomeFragment extends Fragment {
    private ArrayList<Album> albumList = new ArrayList<>();

    private ArrayList<Album> contactGroupList = new ArrayList<>();

    private File file;

    private String FileType;

    @BindView(R.id.albums_grid_view)
    RecyclerView albumsGridView;

    @BindView(R.id.contacts_group_grid_view)
    RecyclerView contactsGridView;

    @BindView(R.id.add_button)
    Button addButton;

    @BindView(R.id.remove_button)
  Button removeButton;

    @BindView(R.id.bottom_add_button)
            Button bottomAddButton;

    @BindView(R.id.bottom_remove_button)
            Button bottomRemoveButton;


    @BindView(R.id.button_back)
    ImageView buttonTop;

    @BindView(R.id.button_back_bottom)
    ImageView BUttonBackbottom;

    @BindView(R.id.button_layout)
    LinearLayout topButtonLayout;

    @BindView(R.id.bottom_button_layout)
    LinearLayout bottomButtonLayout;




    ItemAdapter albumAdapter;

    ItemAdapter contactAdapter;


    private Unbinder unbinder;





    int Type;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home,container,false);





        unbinder = ButterKnife.bind(this,rootView);

        albumsGridView.setLayoutManager(new GridLayoutManager(getContext(),3));

        albumAdapter = new ItemAdapter(getActivity(),albumList,1);

        albumsGridView.setAdapter(albumAdapter);

        contactsGridView.setLayoutManager(new GridLayoutManager(getContext(),2));

        contactAdapter = new ItemAdapter(getActivity(),contactGroupList,0);



        contactsGridView.setAdapter(contactAdapter);
        addItemsToAlbumList();

        addItemsToContactList();





        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewToItemsList();
                albumAdapter.notifyDataSetChanged();
            }
        });

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                albumAdapter.removeItems();

                albumAdapter.notifyDataSetChanged();

            }
        });

        bottomAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItemsToContactList();
                contactAdapter.notifyDataSetChanged();

            }
        });

       bottomRemoveButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               contactAdapter.removeItems();

               contactAdapter.notifyDataSetChanged();

           }
       });

       buttonTop.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               albumAdapter.AddItems();
               albumAdapter.notifyDataSetChanged();

               buttonTop.setVisibility(View.GONE);

           }
       });

       BUttonBackbottom.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               contactAdapter.addBottomItems();
               contactAdapter.notifyDataSetChanged();

               BUttonBackbottom.setVisibility(View.GONE);

           }
       });
       
        return rootView;
    }
    
    public void addItemsToAlbumList(){
       ArrayList<Album> photo = new ArrayList<Album>();
       photo.add(new Album(R.drawable.download_one,"1",null));

        photo.add(new Album(R.drawable.download_three,"2",null));

        photo.add(new Album(R.drawable.download_one,"3",null));

        photo.add(new Album(R.drawable.download_three,"4",null));



        albumList.add(new Album(R.drawable.download_five,"Album A",photo));
        ArrayList<Album> photo1 = new ArrayList<Album>();
        photo1.add(new Album(R.drawable.download_one,"1",null));

        photo1.add(new Album(R.drawable.download_three,"2",null));

        photo1.add(new Album(R.drawable.download_one,"3",null));

        photo1.add(new Album(R.drawable.download_three,"4",null));



        albumList.add(new Album(R.drawable.download_eight,"Album B",photo1));

        
        ArrayList<Album> photo2 = new ArrayList<Album>();
        photo2.add(new Album(R.drawable.download_one,"1",null));

        photo2.add(new Album(R.drawable.download_three,"2",null));

        photo2.add(new Album(R.drawable.download_one,"3",null));

        photo2.add(new Album(R.drawable.download_three,"4",null));
        
        albumList.add(new Album(R.drawable.download_four,"Album C",photo2));

        ArrayList<Album> photo3 = new ArrayList<Album>();
        photo3.add(new Album(R.drawable.download_five,"1",null));

        photo3.add(new Album(R.drawable.download_six,"2",null));

        photo3.add(new Album(R.drawable.download_seven,"3",null));

        photo3.add(new Album(R.drawable.download_eight,"4",null));

        albumList.add(new Album(R.drawable.downloa,"Album C",photo3));

        ArrayList<Album> photo4 = new ArrayList<Album>();
        photo4.add(new Album(R.drawable.download_one,"1",null));

        photo4.add(new Album(R.drawable.download_three,"2",null));

        photo4.add(new Album(R.drawable.download_six,"3",null));

        photo4.add(new Album(R.drawable.download_seven,"4",null));

        albumList.add(new Album(R.drawable.download_eight,"Album D",photo4));

        ArrayList<Album> photo5 = new ArrayList<Album>();
        photo5.add(new Album(R.drawable.download_one,"1",null));

        photo5.add(new Album(R.drawable.download_three,"2",null));

        photo5.add(new Album(R.drawable.download_one,"3",null));

        photo5.add(new Album(R.drawable.download_three,"4",null));

        albumList.add(new Album(R.drawable.download_eleven,"Album E",photo5));

        ArrayList<Album> photo6 = new ArrayList<Album>();
        photo6.add(new Album(R.drawable.download_one,"1",null));

        photo6.add(new Album(R.drawable.download_tweleve,"2",null));

        photo6.add(new Album(R.drawable.download_five,"3",null));

        photo6.add(new Album(R.drawable.download_seven,"4",null));

        albumList.add(new Album(R.drawable.download_ten,"Album F",photo6));


    }
    
    public void addNewToItemsList(){
        ArrayList<Album> photo7 = new ArrayList<Album>();
        photo7.add(new Album(R.drawable.download_four,"1",null));

        photo7.add(new Album(R.drawable.download_six,"2",null));

        photo7.add(new Album(R.drawable.download_seven,"3",null));

        photo7.add(new Album(R.drawable.download_five,"4",null));

        albumList.add(new Album(R.drawable.download_tweleve,"Album G",photo7));


    }
    public void addItemsToContactList(){
        ArrayList<Album> photo = new ArrayList<Album>();
        photo.add(new Album(R.drawable.ic_perm_contact_calendar_black_24dp,"1",null));

        photo.add(new Album(R.drawable.ic_perm_contact_calendar_black_24dp,"2",null));

        photo.add(new Album(R.drawable.ic_perm_contact_calendar_black_24dp,"3",null));
        contactGroupList.add(new Album(R.drawable.ic_group_white_48dp,"Contact Group 1",photo));

        ArrayList<Album> photo1 = new ArrayList<Album>();
        photo1.add(new Album(R.drawable.ic_perm_contact_calendar_black_24dp,"1",null));

        photo1.add(new Album(R.drawable.ic_perm_contact_calendar_black_24dp,"2",null));

        photo1.add(new Album(R.drawable.ic_perm_contact_calendar_black_24dp,"3",null));
        contactGroupList.add(new Album(R.drawable.ic_group_white_48dp,"Contact Group 1",photo1));

        ArrayList<Album> photo2 = new ArrayList<Album>();
        photo2.add(new Album(R.drawable.ic_perm_contact_calendar_black_24dp,"1",null));

        photo2.add(new Album(R.drawable.ic_perm_contact_calendar_black_24dp,"2",null));

        photo2.add(new Album(R.drawable.ic_perm_contact_calendar_black_24dp,"3",null));
        contactGroupList.add(new Album(R.drawable.ic_group_white_48dp,"Contact Group 2",photo2));

        ArrayList<Album> photo3 = new ArrayList<Album>();
        photo3.add(new Album(R.drawable.ic_perm_contact_calendar_black_24dp,"1",null));

        photo3.add(new Album(R.drawable.ic_perm_contact_calendar_black_24dp,"2",null));

        photo3.add(new Album(R.drawable.ic_perm_contact_calendar_black_24dp,"3",null));
        contactGroupList.add(new Album(R.drawable.ic_group_white_48dp,"Contact Group 3",photo3));

        ArrayList<Album> photo4 = new ArrayList<Album>();
        photo4.add(new Album(R.drawable.ic_perm_contact_calendar_black_24dp,"1",null));

        photo4.add(new Album(R.drawable.ic_perm_contact_calendar_black_24dp,"2",null));

        photo4.add(new Album(R.drawable.ic_perm_contact_calendar_black_24dp,"3",null));
        contactGroupList.add(new Album(R.drawable.ic_group_white_48dp,"Contact Group 4",photo4));

        ArrayList<Album> photo5 = new ArrayList<Album>();
        photo5.add(new Album(R.drawable.ic_perm_contact_calendar_black_24dp,"1",null));

        photo5.add(new Album(R.drawable.ic_perm_contact_calendar_black_24dp,"2",null));

        photo5.add(new Album(R.drawable.ic_perm_contact_calendar_black_24dp,"3",null));
        contactGroupList.add(new Album(R.drawable.ic_group_white_48dp,"Contact Group 5",photo5));

        ArrayList<Album> photo6 = new ArrayList<Album>();
        photo6.add(new Album(R.drawable.ic_perm_contact_calendar_black_24dp,"1",null));

        photo6.add(new Album(R.drawable.ic_perm_contact_calendar_black_24dp,"2",null));

        photo6.add(new Album(R.drawable.ic_perm_contact_calendar_black_24dp,"3",null));
        contactGroupList.add(new Album(R.drawable.ic_group_white_48dp,"Contact Group 6",photo6));



    }
    public void addNewItemsToContactList(){
        ArrayList<Album> photo7 = new ArrayList<Album>();
        photo7.add(new Album(R.drawable.ic_perm_contact_calendar_black_24dp,"1",null));

        photo7.add(new Album(R.drawable.ic_perm_contact_calendar_black_24dp,"2",null));

        photo7.add(new Album(R.drawable.ic_perm_contact_calendar_black_24dp,"3",null));
        contactGroupList.add(new Album(R.drawable.ic_group_white_48dp,"Contact Group 7",photo7));
        
    }

    @Optional
    @OnClick(R.id.item_layout)
    public void doit(){
        Toast.makeText(getContext(),"okay",Toast.LENGTH_SHORT).show();

    }






    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();



    }

    public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {
        private Context mContext;

        private List<Album> itemArrayList;

        private List<Album> tempArrayList;


        private List<Album> bottomArrayList;

        List<Album> topArrayList;


        private int FileType;


        private String SNACKBAR_TITLE;

        private String INTENT_TYPE;

        public ItemAdapter(Context mContext, List<Album> fileArrayList, int FileType) {

            topArrayList = new ArrayList<Album>();

            bottomArrayList = new ArrayList<>();

            tempArrayList = new ArrayList<Album>();


            this.mContext = mContext;
            this.itemArrayList = fileArrayList;
            this.FileType = FileType;

            if (FileType == 1) {

                this.topArrayList = itemArrayList;

            } else if (FileType == 0) {

                this.bottomArrayList = itemArrayList;

            }


        }

        @NonNull
        @Override
        public ItemAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_image, parent, false);

            return new ItemAdapter.MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            Album album = itemArrayList.get(position);

            holder.nameTextView.setText(album.getAlbumName());

            holder.checkBox.setChecked(false);

            Glide.with(mContext)
                    .load(album.getImageResource())
                    .into(holder.mSquareImage);

        }

        @Override
        public int getItemCount() {
            return itemArrayList.size();
        }


        public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener,View.OnDragListener {
            public int ViewPosition;
            @BindView(R.id.item_photo)
            SquareImage mSquareImage;

            @BindView(R.id.nametextView)
            TextView nameTextView;

            @BindView(R.id.check_box)
            CheckBox checkBox;


            public MyViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
                mSquareImage.setPadding(2, 2, 2, 2);
                mSquareImage.setOnClickListener(this);
                mSquareImage.setOnLongClickListener(this);

                checkBox.setOnClickListener(this);
                mSquareImage.setOnDragListener(this);
                checkBox.setBackgroundColor(mContext.getResources().getColor(R.color.white));


            }


            @Override
            public void onClick(View v) {

                int position = getAdapterPosition();

                HomeFragment homeFragment = new HomeFragment();


                Album album = itemArrayList.get(position);

                switch (v.getId()) {
                    case R.id.check_box:
                        if (checkBox.isChecked()) {

                            tempArrayList.add(itemArrayList.get(position));


                        } else {
                            tempArrayList.remove(itemArrayList.get(position));


                        }
                        break;
                    case R.id.item_photo:
                        if (album.getPhotoArrayList() != null) {

                            if (topArrayList.contains(album)) {
                                itemArrayList.clear();
                                itemArrayList.addAll(album.getPhotoArrayList());
                                notifyDataSetChanged();
                                buttonTop.setVisibility(View.VISIBLE);


                                topButtonLayout.setVisibility(View.GONE);
                                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                                        RelativeLayout.LayoutParams.MATCH_PARENT,
                                        RelativeLayout.LayoutParams.WRAP_CONTENT
                                );
                                params.setMargins(Math.round(convertDpToPixel(30, mContext)), Math.round(convertDpToPixel(10, mContext)), Math.round(convertDpToPixel(15, mContext)), Math.round(convertDpToPixel(5, mContext)));
                                albumsGridView.setLayoutParams(params);

                            } else if (bottomArrayList.contains(album)) {
                                itemArrayList.clear();
                                itemArrayList.addAll(album.getPhotoArrayList());
                                notifyDataSetChanged();
                                BUttonBackbottom.setVisibility(View.VISIBLE);


                                bottomButtonLayout.setVisibility(View.GONE);
                                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                                        RelativeLayout.LayoutParams.MATCH_PARENT,
                                        RelativeLayout.LayoutParams.WRAP_CONTENT
                                );
                                params.setMargins(Math.round(convertDpToPixel(30, mContext)), Math.round(convertDpToPixel(10, mContext)), Math.round(convertDpToPixel(15, mContext)), Math.round(convertDpToPixel(5, mContext)));
                                contactsGridView.setLayoutParams(params);

                            }


                        }

                }

            }

            @Override
            public boolean onLongClick(View v) {

                int position = getAdapterPosition();



                Album album = itemArrayList.get(position);


                if (topArrayList.contains(album)){

                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);

                    // Starts the drag
                    v.startDrag(null//data to be dragged
                            , shadowBuilder //drag shadow
                            , v//local data about the drag and drop operation
                            , 0//no needed flags
                    );

                }


                return true;

            }




            @Override
            public boolean onDrag(View v, DragEvent event) {
                int position = getAdapterPosition();





                Album album = itemArrayList.get(position);

                v.getBackground().clearColorFilter();

                // Invalidates the view to force a redraw
                v.invalidate();


                if (event.getAction()==DragEvent.ACTION_DRAG_STARTED){



                }


                if (event.getAction() ==DragEvent.ACTION_DRAG_ENDED){
                    Toast.makeText(mContext,"Data Sent",Toast.LENGTH_SHORT).show();

                    return false;
                }
                return false;

            }
        }

        public float convertDpToPixel(float dp, Context context) {
            Resources resources = context.getResources();
            DisplayMetrics metrics = resources.getDisplayMetrics();
            float px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
            return px;
        }
        public void removeItems() {

            itemArrayList.removeAll(tempArrayList);

            notifyDataSetChanged();

        }

        public void AddItems() {
            albumList.clear();

            albumAdapter = new ItemAdapter(getActivity(), albumList, 1);

            albumsGridView.setAdapter(albumAdapter);


            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(Math.round(convertDpToPixel(15, mContext)), Math.round(convertDpToPixel(10, mContext)), Math.round(convertDpToPixel(15, mContext)), Math.round(convertDpToPixel(38, mContext)));
            albumsGridView.setLayoutParams(params);

            addItemsToAlbumList();

            topButtonLayout.setVisibility(View.VISIBLE);

            notifyDataSetChanged();
        }

        public void addBottomItems() {
            contactGroupList.clear();
            contactAdapter = new ItemAdapter(getActivity(), contactGroupList, 0);

            contactsGridView.setAdapter(contactAdapter);


            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(Math.round(convertDpToPixel(15, mContext)), Math.round(convertDpToPixel(10, mContext)), Math.round(convertDpToPixel(15, mContext)), Math.round(convertDpToPixel(38, mContext)));
            contactsGridView.setLayoutParams(params);
            bottomButtonLayout.setVisibility(View.VISIBLE);

            addItemsToContactList();
            notifyDataSetChanged();
        }

    }


}
