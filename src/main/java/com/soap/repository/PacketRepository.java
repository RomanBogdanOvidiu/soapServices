package com.soap.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.soap.entity.Packet;

@Repository
public interface PacketRepository extends CrudRepository<Packet, Long> {

	Packet findPacketByPackName(String packeName);
}
