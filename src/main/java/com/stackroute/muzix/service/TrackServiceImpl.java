package com.stackroute.muzix.service;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackIdNotFoundException;
import com.stackroute.muzix.exceptions.TrackIdAlreadyExistsException;
import com.stackroute.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrackServiceImpl implements TrackService {

    private TrackRepository trackRepository;
    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if (trackRepository.existsById(track.getTrackId())) {
            throw new TrackAlreadyExistsException("Track Already exists");
        }
        Track savedTrack = (Track) trackRepository.save(track);
        if (savedTrack == null) {
            throw new TrackAlreadyExistsException("Track Already exists");
        }
        return savedTrack;
    }

    @Override
    public Track updateTack(Track track) throws TrackIdAlreadyExistsException {
        if (trackRepository.existsById(track.getTrackId())) {
            throw new TrackIdAlreadyExistsException("Track Already exists");
        }
        Track savedTrack = (Track) trackRepository.save(track);
        if (savedTrack == null) {
            throw new TrackIdAlreadyExistsException("Track Already exists");
        }
        return savedTrack;

    }


    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public boolean deleteTrack(int id) throws TrackIdNotFoundException {
        boolean status = false;
        if (trackRepository.existsById(id)) {

            trackRepository.deleteById(id);

            status = true;
            return status;
        } else {
            return false;
        }
    }
}