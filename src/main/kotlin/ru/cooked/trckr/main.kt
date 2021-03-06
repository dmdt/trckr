package ru.cooked.trckr

import ru.cooked.trckr.adapters.AdjustTrackingAdapter
import ru.cooked.trckr.adapters.AmplitudeTrackingAdapter
import ru.cooked.trckr.adapters.FirebaseTrackingAdapter
import ru.cooked.trckr.converters.EnumConverter
import ru.cooked.trckr.tracker.ApplicationTracker
import ru.cooked.trckr.tracker.data.SearchSource

fun getTracker(): ApplicationTracker = Trckr.new {
    addAdapter(FirebaseTrackingAdapter())
    addAdapter(AmplitudeTrackingAdapter())
    addAdapter(AdjustTrackingAdapter())
    addConverter(EnumConverter())
}

fun main() {
    with(getTracker()) {
        appLaunched()
        searchOpened(
            query = null,
            source = SearchSource.DETAILS_SCREEN,
        )
        searchOpened(
            query = "query",
            source = SearchSource.DETAILS_SCREEN,
        )
        appStopped(isForceStopped = true)
    }
}