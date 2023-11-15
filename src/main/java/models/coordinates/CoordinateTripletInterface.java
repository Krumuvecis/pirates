package models.coordinates;

import org.jetbrains.annotations.NotNull;

//
public interface CoordinateTripletInterface {
    //
    double @NotNull [] getAsArray();

    //
    void setFromArray(double @NotNull [] array);
}