package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackIdNotFoundException;
import com.stackroute.muzix.exceptions.TrackIdAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;

import java.util.List;

public interface TrackService {
public Track saveTrack(Track track) throws TrackAlreadyExistsException;
public Track updateTack(Track track) throws TrackIdAlreadyExistsException;
public List<Track>getAllTracks();
public boolean deleteTrack(int id) throws TrackIdNotFoundException;
}
