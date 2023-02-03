package com.history.nappy.service.cv;

import com.history.nappy.repository.cv.details.CVDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CVDetailsService {

    private final CVDetailsRepository cvDetailsRepository;

}
