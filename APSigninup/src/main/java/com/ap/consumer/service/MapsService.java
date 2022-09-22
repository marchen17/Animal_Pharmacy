package com.ap.consumer.service;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;

@Service
public class MapsService {
	
	private static final String MAPS_ROOT_ENDPOINT= "/maps";
	private String baseUrl = "lb://ap-maps-service/maps";
	
}
