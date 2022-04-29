package com.vinhta.transactionaloutbox.events.repository;

import com.vinhta.transactionaloutbox.events.model.OutboxEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OutboxRepository extends JpaRepository<OutboxEvent, UUID> {}
