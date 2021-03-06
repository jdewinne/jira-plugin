package hudson.plugins.jira;

import hudson.plugins.jira.soap.RemoteComponent;

/**
 * One JIRA issue.
 *
 * <p>
 * This class is used to represent Jira Component
 * so that Jenkins can display it without talking to JIRA.
 *
 * @author jdewinne
 */
public final class JiraComponent implements Comparable<JiraComponent> {
    /**
     * JIRA Issue type id, like "8 = Testing".
     */
    public final String id;

    /**
     * Component name.
     * For example, testing, development, ...
     */
    public final String name;

    public JiraComponent(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public JiraComponent(RemoteComponent remoteComponent) {
        this(remoteComponent.getId(),remoteComponent.getName());
    }

    public int compareTo(JiraComponent that) {
        return this.name.compareTo(that.name);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        JiraComponent other = (JiraComponent) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
