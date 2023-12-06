package com.azshop.dao;


import com.azshop.models.ItemImageModel;

public interface IItemImageDAO {
    void insertItemImage (ItemImageModel ItemId);
	void deleteItemImage (int IteamId);
	void updateItemImage (ItemImageModel ItemId, String newImage);
}