[license]: https://img.shields.io/badge/License-Apache%202.0-lightgrey.svg
[ ![license][] ](https://github.com/cmclient/DiscordIPC2/blob/master/LICENSE)

# DiscordIPC 2.0
Based on: https://github.com/jagrosh/DiscordIPC/blob/master/README.md

Connect locally to the Discord client using IPC for a subset of RPC features like Rich Presence and Activity Join/Spectate

# What was changed compared to the original DiscordRPC

- Changed org.json to google gson library
- Fixed bugs

# Features

- Setting Rich Presence
- Listen for Join, Spectate, and Join-Request events
- Detect and specify priority for client build (Stable, PTB, Canary)
- 100% Java

# Example

- Check [this](https://github.com/cmclient/DiscordIPC2/blob/master/src/main/java/com/jagrosh/discordipc/IPCTest.java) example with rich presence, join, spectate, party 
