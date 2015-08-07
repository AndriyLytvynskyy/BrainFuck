package com.booking.java8.chapt9;

import java.util.function.Consumer;

/**
 * Created by Andrii_Lytvynskyi on 8/5/2015.
 */
public interface ArtistAnalyzer {

        public void isLargerGroup(String artistName,
                                  String otherArtistName,
                                  Consumer<Boolean> handler);

}
