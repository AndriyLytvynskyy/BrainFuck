package com.booking.java8.chapt9;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by Andrii_Lytvynskyi on 8/5/2015.
 */
public class BlockingArtistAnalyzer implements ArtistAnalyzer {

    private final Function<String, Artist> artistLookupService;

    public BlockingArtistAnalyzer(Function<String, Artist> artistLookupService) {
        this.artistLookupService = artistLookupService;
    }

//    public boolean isLargerGroup(String artistName, String otherArtistName) {
//        return getNumberOfMembers(artistName) > getNumberOfMembers(otherArtistName);
//    }

    private Future<Long> getNumberOfMembers(String artistName) {
        Future<Long> future = CompletableFuture.supplyAsync(() -> artistLookupService.apply(artistName)
                .getMembers()
                .count());


        return future;
    }


    @Override
    public void isLargerGroup(String artistName, String otherArtistName, Consumer<Boolean> handler) {
        try {
            handler.accept(getNumberOfMembers(artistName).get() > getNumberOfMembers((otherArtistName)).get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }
}
