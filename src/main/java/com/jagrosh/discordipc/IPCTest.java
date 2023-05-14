package com.jagrosh.discordipc;

import com.jagrosh.discordipc.entities.RichPresence;
import com.jagrosh.discordipc.entities.User;
import com.jagrosh.discordipc.exceptions.NoDiscordClientException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.OffsetDateTime;
import java.util.Random;

public class IPCTest {

    public static void main(String[] args) {
        final Logger logger = LogManager.getLogger();
        logger.debug("IPC Test | Debug Test");

        IPCClient client = new IPCClient(345229890980937739L);

        client.setListener(new IPCListener() {
            @Override
            public void onReady(IPCClient client) {
                logger.info("IPC Ready");

                client.subscribe(IPCClient.Event.ACTIVITY_JOIN);
                client.subscribe(IPCClient.Event.ACTIVITY_SPECTATE);
                client.subscribe(IPCClient.Event.ACTIVITY_JOIN_REQUEST);

                logger.info("IPC Subscribed");

                RichPresence.Builder builder = new RichPresence.Builder();
                builder.setState("Test 1")
                        .setDetails("Test 2")
                        .setStartTimestamp(OffsetDateTime.now());
                builder.setParty("p" + new Random().nextInt(1000), 1, 20);
                builder.setJoinSecret("j" + new Random().nextInt(1000));
                builder.setSpectateSecret("s" + new Random().nextInt(1000));
                client.sendRichPresence(builder.build());
            }

            @Override
            public void onActivityJoin(IPCClient client, String secret) {
                logger.info("IPC onActivityJoin | " + secret);
            }

            @Override
            public void onActivityJoinRequest(IPCClient client, String secret, User user) {
                logger.info("IPC onActivityJoinRequest | " + secret + " | " + user.getName());
            }

            @Override
            public void onActivitySpectate(IPCClient client, String secret) {
                logger.info("IPC onActivitySpectate | " + secret);
            }
        });

        try {
            logger.info("IPC Connecting");
            client.connect();
        } catch (NoDiscordClientException ex) {
            logger.error("IPC Error", ex);
        }
    }
}
