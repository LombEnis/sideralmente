package com.google.android.sideralmente.inject

/**
 * Implemented by activities to access their dagger component.
 * Created by johntaylor on 4/9/16.
 */
interface HasComponent<C> {
    val component: C
}