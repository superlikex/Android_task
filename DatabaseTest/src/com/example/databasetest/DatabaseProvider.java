package com.example.databasetest;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class DatabaseProvider extends ContentProvider {
	
	public static final int BOOK_DIR = 0;
	public static final int BOOK_ITEM = 1;
	public static final int CATEGORY_DIR = 2;
	public static final int CATEGORY_ITEM = 3;
	
	public static final String AUTHORITY = "com.example.databasetest.provider";
	
	private static UriMatcher uriMatcher;
	private MyDatabaseHelper dbHelper;
	static {
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		uriMatcher.addURI(AUTHORITY, "book", BOOK_DIR);
		uriMatcher.addURI(AUTHORITY, "book/#", BOOK_ITEM);
	//	uriMatcher.addURI(AUTHORITY, "category", CATEGORY_DIR);
	//  uriMatcher.addURI(AUTHORITY, "category/#", CATEGORY_ITEM);
		}

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		dbHelper = new MyDatabaseHelper(getContext(), "BookStore.db", null, 2);
		return true;
		//return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		// 查询数据
		SQLiteDatabase db = dbHelper.getReadableDatabase();
		Cursor cursor = null;
		switch (uriMatcher.match(uri)) {
		case BOOK_DIR:
			cursor = db.query("Book", projection, selection, selectionArgs,
			null, null, sortOrder);
			break;
		case BOOK_ITEM:
			String bookId = uri.getPathSegments().get(1);
			cursor = db.query("Book", projection, "id = ?", new String[]
			{ bookId }, null, null, sortOrder);
			break;
	/*	case CATEGORY_DIR:
			cursor = db.query("Category", projection, selection,
					selectionArgs, null, null, sortOrder);
			break;
		case CATEGORY_ITEM:
			String categoryId = uri.getPathSegments().get(1);
			cursor = db.query("Category", projection, "id = ?", new String[]
					{ categoryId }, null, null, sortOrder);
			break;  */
		default:
			break;
		}
		return cursor;
		//return null;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

}
