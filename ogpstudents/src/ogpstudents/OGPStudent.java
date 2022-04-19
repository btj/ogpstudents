package ogpstudents;

/**
 * Each instance of this class represents a student in an OGP student team collaboration graph.
 * 
 * @invar De bidirectionele associatie is consistent.
 *     | getTeammate() == null || getTeammate().getTeammate() == this
 */
public class OGPStudent {
	
	/**
	 * @invar | teammate == null || teammate.teammate == this
	 * 
	 * @peerObject
	 */
	private OGPStudent teammate;
	
	/**
	 * @peerObject
	 */
	public OGPStudent getTeammate() { return teammate; }
	
	/**
	 * @post | getTeammate() == null
	 */
	public OGPStudent() {}

	/**
	 * @pre | other != null
	 * @pre | other.getTeammate() == null
	 * @pre | getTeammate() == null
	 * @mutates | this, other
	 * @post | getTeammate() == other
	 */
	public void teamUpWith(OGPStudent other) {
		this.teammate = other;
		other.teammate = this;
	}
	
	/**
	 * @pre | getTeammate() != null
	 * @mutates | this
	 * @post | getTeammate() == null
	 * @post | old(getTeammate()).getTeammate() == null
	 */
	public void stopCollaboration() {
		this.teammate.teammate = null;
		this.teammate = null;
	}
	
}
