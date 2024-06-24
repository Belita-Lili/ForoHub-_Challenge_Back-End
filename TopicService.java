package com.example.topicsapi.service;

import com.example.topicsapi.model.Topic;
import com.example.topicsapi.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public Topic createTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    public Optional<Topic> getTopicById(Long id) {
        return topicRepository.findById(id);
    }

    public Topic updateTopic(Long id, Topic topicDetails) {
        Topic topic = topicRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Topic not found"));

        topic.setTitle(topicDetails.getTitle());
        topic.setDescription(topicDetails.getDescription());

        return topicRepository.save(topic);
    }

    public void deleteTopic(Long id) {
        Topic topic = topicRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Topic not found"));
        topicRepository.delete(topic);
    }
}