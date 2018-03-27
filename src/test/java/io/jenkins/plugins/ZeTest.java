package io.jenkins.plugins;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.Issue;
import org.jvnet.hudson.test.RestartableJenkinsRule;
import org.jvnet.hudson.test.recipes.LocalData;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@Issue("JENKINS-50422")
public class ZeTest {

    @Rule
    public RestartableJenkinsRule story = new RestartableJenkinsRule();

    @Test // Expected to succeed
    public void withoutLocalData() {
        final Set<String> rootDirs = new HashSet<>();
        story.then(rule -> {
            rootDirs.add(rule.jenkins.getRootDir().toString());
            assertTrue(rootDirs.size() == 1);
        });

        story.then(rule -> {
            rootDirs.add(rule.jenkins.getRootDir().toString());
            assertTrue(rootDirs.size() == 1);
        });
    }

    @LocalData // Expected to fail (without a fix for https://issues.jenkins-ci.org/browse/JENKINS-50422)
    @Test
    public void withLocalData() {
        final Set<String> rootDirs = new HashSet<>();
        story.then(rule -> {
            rootDirs.add(rule.jenkins.getRootDir().toString());
            assertTrue(rootDirs.size() == 1);
        });

        story.then(rule -> {
            rootDirs.add(rule.jenkins.getRootDir().toString());
            assertTrue(rootDirs.size() == 1);
        });
    }
}
