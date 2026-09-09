# AGENTS.md

## Project

A personal Yocto layer built on vendor BSPs. This repo is one layer inside a
larger `repo`-managed workspace; all boards stay on the same Yocto release.
Read `conf/layer.conf` and the existing recipes before changing anything, and
match the local style.

Everything outside this repo — other layers, the build directory, `DL_DIR`,
`SSTATE_DIR` — is out of scope. Don't edit files there and don't hardcode paths
to them; use `${LAYERDIR}` and the usual variables instead.

Add documentation when asked to the `doc/` folder with `ai-agent_` prefix.

## Hard rules

**No builds.** Not to verify a change, not once, not in the background. If a build
is needed to answer something, say so and stop. Forbidden: `bitbake <image|recipe>`,
`bitbake -c build|compile|install|populate_sdk`, `devtool build`, `runqemu`, `wic`.

**bitbake for inspection is fine** — these parse metadata, they don't run tasks:

```
bitbake-getvar -r <recipe> <VAR>      # preferred over `bitbake -e`
bitbake -p                            # parse only
bitbake -n <recipe>                   # what would run
bitbake -c listtasks <recipe>
bitbake -g <recipe> -I <recipe>
bitbake-layers show-layers|show-recipes|show-appends|show-overlayed
oe-pkgdata-util lookup-pkg|find-path|list-pkg-files
```

Show the exact command and the relevant raw output — don't paraphrase it. If a
command turns out to run tasks, kill it and tell me.

**Never invent variables or tasks.** Use only names that exist in the metadata or
the reference manual; verify with `bitbake-getvar` before relying on one. Custom
variables are allowed only in our own recipes, must be prefixed (e.g. `MYDISTRO_`),
and must be flagged as new. If unsure a variable exists, say so instead of guessing.

**Don't touch** anything outside this repo — build output, caches, poky, vendor BSP
layers. Fixes there go in a `.bbappend` here, or get flagged as an upstream patch.
No `cleanall` / `cleansstate`.

**Don't move versions.** Never bump `SRCREV`, a branch, or a manifest revision on
your own. New git `SRC_URI` entries need a pinned `SRCREV` and explicit `branch=`.

## Teaching

I'm learning Yocto as I build this. For any non-trivial change or answer:

1. What you're doing, in a sentence or two.
2. The mechanism behind it, named explicitly (`bbappend` ordering, `BBFILE_PRIORITY`,
   override syntax, `PACKAGECONFIG`, sstate signatures, `DEPENDS` vs `RDEPENDS`,
   native/target classes).
3. The command I can run to verify it, and what correct output looks like.
4. The specific manual section to read — not just "the docs".

Explain why a mechanism exists in a cross-compiled, cached build, not just its
syntax. Gloss unfamiliar variables on first use. Flag footguns (unconditional
`:append`, `${PN}` vs `${BPN}`, unshipped files failing `do_package_qa`, stale
`LIC_FILES_CHKSUM`). If my question rests on a wrong assumption, correct it.

## Conventions

- `recipes-<category>/<recipe>/<recipe>_<ver>.bb`, files in `files/`.
- Modern override syntax (`:append`, `:remove`, `:machine`) — never the underscore form.
- Every recipe: `SUMMARY`, `DESCRIPTION`, `LICENSE`, `LIC_FILES_CHKSUM`, `SRC_URI`.
- Prefer `PACKAGECONFIG` over patching build systems. Patches carry `Upstream-Status:`.
- A `.bbappend` overriding vendor behaviour needs a comment saying why.
- Commits: `<recipe>: <what changed>`, body explains why, one logical change each.
- **Never add `Signed-off-by`** — that's mine. Only `Assisted-by: <model name and
  version>` as the last trailer, no other attribution lines.

## Stop and ask when

- Validating the change would need a build.
- The fix belongs in a vendor layer or poky.
- A version, branch, or `SRCREV` would have to move.
- You're about to add a workaround you can't fully explain.

"I don't know, here's the command that would settle it" beats a guess.
