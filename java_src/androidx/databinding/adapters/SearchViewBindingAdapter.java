package androidx.databinding.adapters;

import android.os.Build;
import android.widget.SearchView;
/* loaded from: classes.dex */
public class SearchViewBindingAdapter {

    /* loaded from: classes.dex */
    public interface OnQueryTextChange {
        boolean onQueryTextChange(String str);
    }

    /* loaded from: classes.dex */
    public interface OnQueryTextSubmit {
        boolean onQueryTextSubmit(String str);
    }

    /* loaded from: classes.dex */
    public interface OnSuggestionClick {
        boolean onSuggestionClick(int i);
    }

    /* loaded from: classes.dex */
    public interface OnSuggestionSelect {
        boolean onSuggestionSelect(int i);
    }

    public static void setOnQueryTextListener(SearchView searchView, final OnQueryTextSubmit onQueryTextSubmit, final OnQueryTextChange onQueryTextChange) {
        if (Build.VERSION.SDK_INT >= 11) {
            if (onQueryTextSubmit == null && onQueryTextChange == null) {
                searchView.setOnQueryTextListener(null);
            } else {
                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() { // from class: androidx.databinding.adapters.SearchViewBindingAdapter.1
                    @Override // android.widget.SearchView.OnQueryTextListener
                    public boolean onQueryTextSubmit(String str) {
                        OnQueryTextSubmit onQueryTextSubmit2 = OnQueryTextSubmit.this;
                        if (onQueryTextSubmit2 != null) {
                            return onQueryTextSubmit2.onQueryTextSubmit(str);
                        }
                        return false;
                    }

                    @Override // android.widget.SearchView.OnQueryTextListener
                    public boolean onQueryTextChange(String str) {
                        OnQueryTextChange onQueryTextChange2 = onQueryTextChange;
                        if (onQueryTextChange2 != null) {
                            return onQueryTextChange2.onQueryTextChange(str);
                        }
                        return false;
                    }
                });
            }
        }
    }

    public static void setOnSuggestListener(SearchView searchView, final OnSuggestionSelect onSuggestionSelect, final OnSuggestionClick onSuggestionClick) {
        if (Build.VERSION.SDK_INT >= 11) {
            if (onSuggestionSelect == null && onSuggestionClick == null) {
                searchView.setOnSuggestionListener(null);
            } else {
                searchView.setOnSuggestionListener(new SearchView.OnSuggestionListener() { // from class: androidx.databinding.adapters.SearchViewBindingAdapter.2
                    @Override // android.widget.SearchView.OnSuggestionListener
                    public boolean onSuggestionSelect(int i) {
                        OnSuggestionSelect onSuggestionSelect2 = OnSuggestionSelect.this;
                        if (onSuggestionSelect2 != null) {
                            return onSuggestionSelect2.onSuggestionSelect(i);
                        }
                        return false;
                    }

                    @Override // android.widget.SearchView.OnSuggestionListener
                    public boolean onSuggestionClick(int i) {
                        OnSuggestionClick onSuggestionClick2 = onSuggestionClick;
                        if (onSuggestionClick2 != null) {
                            return onSuggestionClick2.onSuggestionClick(i);
                        }
                        return false;
                    }
                });
            }
        }
    }
}
