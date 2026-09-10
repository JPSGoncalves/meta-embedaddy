# meta-embedaddy

A set of Yocto layers for **EmbeDaddy**, a minimal systemd-based Linux
distribution.

## This directory is not a layer

`meta-embedaddy/` has no `conf/layer.conf`. It is a container that holds
layers; the layers are its subdirectories. Adding this directory to `BBLAYERS`
will not work -- add the subdirectory you want:

```
BBLAYERS += "${TOPDIR}/../layers/meta-embedaddy/meta-embedaddy-distro"
```

## Layers

| Layer | Contains |
|---|---|
| `meta-embedaddy-distro` | The distro configuration. |
| `meta-embedaddy-bsp-common` | Recipes shared by every board, currently the mainline kernel. |

Per-board BSP layers are added here as boards arrive.

## Documentation

`doc/` holds the glossary (`ai-agent_context.md`) and the architecture decision
records (`ai-agent_adr-*.md`). Read the glossary first: it fixes the meaning of
terms such as *overlap*, *board-agnostic* and *read-only friendly*, which are
used precisely rather than loosely throughout this repository.
