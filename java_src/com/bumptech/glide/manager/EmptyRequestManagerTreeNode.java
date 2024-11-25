package com.bumptech.glide.manager;

import com.bumptech.glide.RequestManager;
import java.util.Collections;
import java.util.Set;
/* loaded from: classes.dex */
final class EmptyRequestManagerTreeNode implements RequestManagerTreeNode {
    @Override // com.bumptech.glide.manager.RequestManagerTreeNode
    public Set<RequestManager> getDescendants() {
        return Collections.emptySet();
    }
}
